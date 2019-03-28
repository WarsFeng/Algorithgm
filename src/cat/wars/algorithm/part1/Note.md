# Part one
何为算法？
> 算法就是把输入转换成输出的计算步骤的一个序列。  
Big idea:
* Asymptotic analysis(渐进分析)  
is to ignore machine-dependent constants
and, instead of the actual running time.
look at the growth of the running time.  
**Θ(theta): From a formula, just drop low order terms and ignore leading constants.**  
Example: 3n^3+90n^2-5n+6046 -- Θ(n^3)  
当我们关注当n趋向于无穷大的情况，就知道一个Θ(n^2)的算法, 迟早会战胜一个Θ(n^3)的算法  
渐进符号的伟大之处在于: 他能一举满足我们对相对(相同平台)和绝对(不同平台)速度的双重比较要求.
当n越来越大, **总会有一个值x**, 比它大的任何数, Θ(n^2)的算法都比Θ(n^3)有更好的开销.
这个x可能很大, 所以对某些低规模的输入, Θ(n^3)可能更有用.

### 算法需求所共有的两个特征：
> 1. 存在许多候选解
> 2. 存在实际应用

### 循环不变式性质：
1. 初始化：循环第一次迭代之前, 它为真
2. 保持：如果某次迭代前它为真, 下次迭代前它仍为真
3. 终止：在循环终止时, 不变式为我们提供一个有用的性质, 该性质有助于证明算法是正确的

### 伪代码约定：
* 缩进表示结构
* 循环计数器在退出循环后, 依然保持其值  
如for j=2 to A.length  
可理解为for(j=2; j<=A.length; j++)  
循环结束时, j = A.length+1, 循环计数器保持其值
* // 为注释
* 多重赋值, i=j=e等价于j=e; i=j;
* 变量是局部于给定过程的。若无显式说明,我们不使用全局变量
* 访问数组：数组名[下标], A[x..y]表示A中从x下标到y下标元素组成的一个子数组
* 复合数据赋值为指针赋值, 复合数据的变量为一个指针, 可串联(y=x.f, y.g 等价于 x.f.g)。如果一个指针不指向任何对象, 我们付给它特殊值NIL
* 过程参数传递可理解为复制指针传递，数组变量也是一个指针
* 伪代码允许return返回多个值
* and 和 or都是短路的, 且可以x!=NIL and x.f=y
* 关键词error表示因为已被调用的过程情况不对而出现了一个错误, 调用过程负责处理该错误，所以我们不用说明将采取什么行动

## Merge sort
Merge sort A[1...n]
1. If n=1, done
2. Recursively sort A[1...[n/2]] and [[n/2]+1...n]
3. Merge 2 sorted lists