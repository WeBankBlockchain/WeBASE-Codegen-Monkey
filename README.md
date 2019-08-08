
# WeBASE-Codegen-Monkey

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Gitter](https://badges.gitter.im/WeBASE-Codegen-Monkey/WeBASE-Codegen-Monkey.svg)](https://gitter.im/WeBASE-Codegen-Monkey/community)


> 道生一，一生二，二生三，三生万物。
> 万物负阴而抱阳，冲气以为和。
> 人之所恶，唯孤、寡、不谷，而王公以为称。
> 故物或损之而益，或益之而损。
> 人之所教，亦我而教人。
> 强梁者不得其死——吾将以为教父。
> -- 老子


---

代码自动生成组件：WeBASE-Codegen-Monkey是WeBASE数据导出工具的代码生成组件，可帮助用户自动生成基于[FISCO BCOS](https://github.com/FISCO-BCOS/FISCO-BCOS/tree/master)的数据导出组件[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)。

只需要在一个配置文件中进行少量简单的配置，同时按照要求提供相关的智能合约信息；当前版本可支持自动生成[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)。


**此版本只支持**[FISCO BCOS 2.0](https://fisco-bcos-documentation.readthedocs.io/zh_CN/latest/)。


## 关键特性

#### 自动生成数据导出组件
只需用户提供智能合约编译后的Java代码和相关的底层链、数据库的基本信息，WeBASE-Codegen-Monkey就能帮助你自动生成一个区块链数据导出的组件。现阶段，支持将数据导出到Mysql数据库中。

#### 支持自定义导出数据内容
可以支持导出区块链的基本信息、智能合约的函数、Event等信息。可以对导出的数据库表、字段进行定制。也可以修改导出数据字段的名称、长度等属性。

#### 内置Restful API，提供常用的查询功能
自带常用的Restful API，支持查询块高、块信息、Event信息和函数信息等。

#### 支持多数据源，支持读写分离和分库分表
为了应对海量数据的导出，[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)数据导出组件集成了sharding-jdbc,支持可配置的多数据源存储，读写分离和分库分表：数据可以存储到多个表中，也可以存储到多个库中。同时，内置的Restful API可以自动无感知地返回正常的数据。

#### 支持多活部署，多节点自动导出
[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)数据导出组件支持多活部署，可自动进行分布式任务调度。

#### 支持区块重置导出
[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)数据导出组件基于区块高度进行导出，并支持指定高度重新导出数据。

### 支持可视化的监控页面
[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)可与grafana深度集成，支持自动生成dashboard实例，让您的链上数据了如指掌。

#### 提供可视化的互动API控制台
[WeBASE-Collect-Bee](https://github.com/WeBankFinTech/WeBASE-Collect-Bee/tree/master)集成了swagger插件，提供可视化互动API控制台。


## 环境要求

在使用本组件前，请确认系统环境已安装相关依赖软件，清单如下：

| 依赖软件 | 说明 |备注|
| --- | --- | --- |
| FISCO-BCOS | >= 2.0， 1.x版本请参考V0.5版本 |
| Bash | 需支持Bash（理论上来说支持所有ksh、zsh等其他unix shell，但未测试）|
| Java | >= JDK[1.8] ||
| Git | 下载的安装包使用Git | |
| MySQL | >= mysql-community-server[5.7] | 理论上来说支持主流数据库，但未测试|
| zookeeper | >= zookeeper[3.4] | 只有在进行集群部署的时候需要安装|
| docker    | >= docker[18.0.0] | 只有需要可视化监控页面的时候才需要安装|

## 文档
- [**中文**](https://webasedoc.readthedocs.io/zh_CN/dev-1.0.2/docs/WeBASE-Codegen-Monkey/index.html)
- [**快速安装**](https://webasedoc.readthedocs.io/zh_CN/dev-1.0.2/docs/WeBASE-Codegen-Monkey/install.html#)

## 贡献代码
欢迎参与本项目的社区建设：
- 如项目对您有帮助，欢迎点亮我们的小星星(点击项目左上方Star按钮)。
- 欢迎提交代码(Pull requests)。
- [提问和提交BUG](https://github.com/WeBankFinTech/WeBASE-Codegen-Monkey/issues)。
- 如果发现代码存在安全漏洞，请在[这里](https://security.webank.com)上报。

## 加入我们的社区

FISCO BCOS开源社区是国内活跃的开源社区，社区长期为机构和个人开发者提供各类支持与帮助。已有来自各行业的数千名技术爱好者在研究和使用FISCO BCOS。如您对FISCO BCOS开源技术及应用感兴趣，欢迎加入社区获得更多支持与帮助。


![](https://media.githubusercontent.com/media/FISCO-BCOS/LargeFiles/master/images/QR_image.png)


## License
![license](http://img.shields.io/badge/license-Apache%20v2-blue.svg)

开源协议为[Apache License 2.0](http://www.apache.org/licenses/). 详情参考[LICENSE](../LICENSE)。