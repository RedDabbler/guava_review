package com.redDabbler.review.pattern.wrapper;

//包装模式
// 举个例子
// 咖啡里需要加牛奶，摩卡，豆浆，糖 等来点缀咖啡的味道  这些东西都有他们类似的特点

//咖啡是一种饮料，咖啡的本质是咖啡豆+水磨出来的。咖啡店现在要卖各种口味的咖啡，如果不使用装饰模式，那么在销售系统中，
// 各种不一样的咖啡都要产生一个类，如果有4中咖啡豆，5种口味，那么将要产生至少20个类（不包括混合口味），非常麻烦。
// 使用了装饰模式，只需要11个类即可生产任意口味咖啡（包括混合口味）

// 动态sql的构建是不是也可以使用？

// 比较适用于基本组件的拼装，如swing组件