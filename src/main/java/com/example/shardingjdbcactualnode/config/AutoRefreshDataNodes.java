package com.example.shardingjdbcactualnode.config;

import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.apache.shardingsphere.infra.config.rule.RuleConfiguration;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Collection;

@Component
public class AutoRefreshDataNodes implements ApplicationListener<ApplicationReadyEvent> {
    @Resource
    private ShardingSphereDataSource dataSource;

    public void refreshDataNOdes(){
        String dataSourceName = "logic_db";
        ContextManager contextManager = getContextManager();
        Collection<RuleConfiguration> oldRuleConfigList = contextManager
                .getMetaDataContexts()
                .getMetaData().getDatabase(dataSourceName)
                .getRuleMetaData()
                .getConfigurations();
        for(RuleConfiguration config : oldRuleConfigList) {
            if(!(config instanceof ShardingRuleConfiguration)) {
                continue;
            }
            ShardingRuleConfiguration ruleConfiguration = (ShardingRuleConfiguration)config;
            ruleConfiguration.getTables().forEach((ruleConfig)->{
                if("t_order".equals(ruleConfig.getLogicTable())) {
                    /**
                     * 此处根据实际存在的表设置actualNodes，demo做简化处理
                     */
                    setActualDataNodes(ruleConfig,"ds-0.t_order_$->{2..3}");
                }
            });
        }
        contextManager.alterRuleConfiguration(dataSourceName,oldRuleConfigList);
        contextManager.getMetaDataContexts().getPersistService().getDatabaseRulePersistService().persist(dataSourceName,oldRuleConfigList);
    }

    private ContextManager getContextManager(){
        try {
            Field field = dataSource.getClass().getDeclaredField("contextManager");
            field.setAccessible(true);
            return (ContextManager)field.get(dataSource);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setActualDataNodes(ShardingTableRuleConfiguration ruleConfig,String actualDataNodes){
        try {
            Field field = ShardingTableRuleConfiguration.class.getDeclaredField("actualDataNodes");
            field.setAccessible(true);
            field.set(ruleConfig,actualDataNodes);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        refreshDataNOdes();
    }
}
