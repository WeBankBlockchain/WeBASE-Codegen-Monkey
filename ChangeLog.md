# 更新历史

#### V0.6.0
- 适配FISCO-BCOS 2.0。
- 重构了主要的日志打印，便于显示和监控。
- 新增了任务准备环节的事务控制。
- 增加了对任务控制环节的扫描检查阶段，可自动检查缺块或少块等。
- 修复了合约无event会报错的问题。
- 将Mysql字符集从utf8改为utf8mb4。
- 新增支持『原始数据命名』的数据库字段命名方式。

#### V0.5.0 (2019-04-02)

- 增加了数据导出的业务监控可视化页面，并支持自动化配置；
- 重构数据回滚和异常处理的流程,增加了数据下载异常、超时的判断和处理；
- 增加了链分叉判断的处理逻辑；
- 重构了单机模式数据同步的流程和数据结构，合并为统一的block_task_pool表；
- 支持设置从某个时间或某个区块高度导出区块数据；
- 支持手动回滚并重新导出某个区块数据；

#### V0.4.0 (2019-03-18)

- 集成sharding-jdbc，支持分库分表导出
- 集成elastic-job，支持集群部署
- 支持静态数组StaticArray的导出

#### V0.3.0 （2018-12-25）

- 增加OpenAPI,支持以Restful的接口直接获取后台数据；
- 支持Method数据导出的开关；
- 修复各类已知bug；
- 完善设计等文档；

---

#### V0.2.0 （2018-12-21）

- 增加Method数据depot功能；
- 增加合约地址depot功能；
- 修改任务分配方式，改为以Block为单位；
- 支持智能下载的策略；
- 支持Bytes等格式数据的解析；
- 修改depot表的结构；

---

#### V0.1.0 （2018-12-18）
- 支持合约Event数据导出；
- 支持根据脚本自动生成和执行；
- 可基于多线程导出Events数据；