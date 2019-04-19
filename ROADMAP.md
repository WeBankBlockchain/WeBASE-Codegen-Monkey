# Roadmap

## WEBASE-MONKEY

### 新功能规划
- [ ] 适配FISCO-BCOS 2.0
- [ ] 支持自动化生成日志采集模块
- [ ] 支持数据导出到ElasticSearch，并提供ES搜索引擎的查询接口
- [ ] 支持灵活的复杂查询
- [ ] 支持数据导出到Hadoop，并提供基本的大数据报表查询支持
- [ ] 支持数据导出到Kafka，并集成spark
- [ ] 支持Flink

### 修复与增强
- [ ] 重构自动生成的脚本，添加更多的操作选项
- [ ] 开发grafana console，使之全部自动化
- [ ] 为grafana展示提供更多内置的指标
- [ ] 集成travis，完善ci
- [ ] 完善现有的单元测试
- [ ] 集成checkstyle等代码检测工具

## WEBASE-BEE

### 新功能规划
- [ ] 接入FISCO-BCOS 2.0的日志，并解析
- [ ] 提供基本的业务监控功能
- [ ] 更细粒度的监控指标，包含机器和应用
- [ ] 接入WEBASE-FRONT，与之打通
- [ ] 支持PreCompile合约
- [ ] 支持WEBASE-BEE集群，新增immuteble的调度策略
- [ ] 提供独立的数据审计和数据完整性检查的模块
- [ ] 支持Topic机制，实现基于Topic的数据导出与治理


### 修复与增强
- [x] 修复FISCO-BCOS长连接中断无法重连的问题
- [ ] 修复FISCO-BCOS频繁闪断后无法重连的问题
- [x] 修复FISCO-BCOS节点断掉后部分数据异常的问题
- [ ] 解决FISCO-BCOS 2.0 函数报文解析失败的问题
- [ ] 提供更为强大的数据查询引擎