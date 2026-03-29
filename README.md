# ☁️ 烽火云短信平台 (Beacon Cloud SMS)

![Java](https://img.shields.io/badge/Java-1.8+-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.X-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

📖 项目简介
面向企业客户与运营商的微服务短信平台，基于 Spring Cloud Alibaba、RabbitMQ、Redis、
Netty、Elasticsearch 构建接口校验、策略编排、通道路由、短信发送、状态回执与日志检索能力，支撑高并发
短信发送场景。

🛠️ 技术栈
核心框架：Spring Cloud 
数据存储：MySQL 
缓存与限流：Redis
消息队列：RabbitMQ  
其他组件：Nacos、OpenFeign、Elasticsearch、Netty、XXL-JOB

✨ 核心功能
•架构解耦与动态配置：设计并实现双层动态规则引擎。接口层基于 Nacos 动态配置 APIKey、IP 白名单、签
名、模板等校验顺序；策略层基于 Redis 按客户配置动态执行黑名单、敏感词、限流、路由等规则，提升规则
扩展性与配置灵活性。
•毫秒级敏感词过滤：实现敏感词过滤能力。将敏感词词库从 Redis 预热到 JVM，本地基于 DFA / WordTree执
行匹配，减少远程调用开销，提升高并发下过滤效率。
•多维度滑动窗口限流：基于 Redis ZSet 实现验证码场景限流能力，落地“1 分钟 1 条”“1 小时 3 条”滑动窗口
规则，有效防止高频重复发送。
•海量检索与数据一致性：基于 Elasticsearch 实现短信发送日志写入、条件检索、分页查询与关键字高亮，满
足后台日志查询需求。
•网关并发通信与动态调优：基于 Netty 封装 CMPP 2.0 客户端，实现长连接、心跳保活、断线重连、编解码及
提交应答/状态报告处理，提升短信网关链路稳定性。
•高可用状态异步触达：基于 RabbitMQ 实现短信发送、 日志写入、状态回执推送的异步解耦，并结合延迟交换
机、TTL、死信队列完成回执重试与日志延迟补偿。

## 🚀 快速开始
1. 克隆项目到本地：
   `git clone https://github.com/你的GitHub用户名/beacon_cloud_own.git`
2. 找到 `sql` 目录下的脚本，在本地 MySQL 中初始化数据库。
3. 修改 `application.yml` (或 `bootstrap.yml`) 中的数据库、Redis、MQ 等连接配置。
4. 启动主程序类，运行项目。

