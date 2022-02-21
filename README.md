# price_calculation
- 程序使用了模板方法模式，路由器对不同的题目进行分发，由具体的子类来处理各自的计算逻辑。
- 程序没有引入Spring，自行实现了依赖反转
- 为方便构建，本程序基于maven
### 入口类
Calculation

### 验证方式
请看测试包org.interview下的测试类
- CalculationTest对入口类Calculation进行验证，通过输入题号和水果斤数，得到水果总价。
  当输入斤数有误或者题号错误的情况，都能按期望抛出异常。
- xxxCalculationTest这几个测试类，分别对子计算器进行验证，通过输入水果斤数，得到水果总价。当输入斤数有误或者题号错误的情况，都能按期望抛出异常。 
