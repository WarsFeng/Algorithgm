# Part one
何为算法？
> 算法就是把输入转换成输出的计算步骤的一个序列。  
Big idea:
* Asymptotic analysis(渐进分析)  
is to ignore machine-dependent constants
and, instead of the actual running time.
look at the growth of the running time.  
### Notation table

 Θ | O | Ω | o | ω
--- | --- | --- | --- | ---
 = | ≤ | ≥ | < | \>


#### OΩ and oω difference  
any constant c, there exists a constant n0  
And so n0 can now depend on c.

### Θ(big-theta) tight bounds
**From a formula, just drop low order terms and ignore leading constants.**  
Example: 3n³+90n²-5n+6046 -> Θ(n³)  
当我们关注当n趋向于无穷大的情况，就知道一个Θ(n²)的算法, 迟早会战胜一个Θ(n³)的算法  
渐进符号的伟大之处在于: 他能一举满足我们对相对(相同平台)和绝对(不同平台)速度的双重比较要求.
当n越来越大, **总会有一个值x**, 比它大的任何数, Θ(n²)的算法都比Θ(n³)有更好的开销.  
这个x可能很大, 所以对某些低规模的输入, Θ(n³)的算法可能更有用.

### O(big-oh) upper bounds
Set definition  
O(g(n)) ∈ f(n)  
there are consts c>0 and n0>0.  
such that 0≤f(n)≤c*g(n)  
for all n≥n0
O(g(n)) = { f(n)  
**Example: 2n² = O(n³)**  
_Macro convention_  
A set in a formula represents an anonymous function in the set.  
f(n) =/is n³+O(n²)  
h(n) =/is O(n²)  
f(n) = n³+h(n)  
**Example: n²+O(n) =/is O(n²)**  
means  
```
for any f(n) ∈ O(n):
    n²+f(n)=h(n)
    for some h(n) ∈ O(n²)
```
#### 代换法解(Substitution method)upper bounds
1. Guess the form of the solution.
2. Verify by induction.
3. Solve for constants.  
Example: T(n) = 4T(n/2) + n
```
Inductive hypothesis: T(k) ≤ c1k2 – c2k for k < n.
         T(n) = 4T(n/2) + n
             = 4(c1(n/2)2 – c2(n/2)) + n
             = c1n2 – 2c2n + n
             = c1n2 – c2n – (c2n – n)
             ≤ c1n2 – c2n if c2 ≥ 1.
```
#### 递归树法(Recursion-tree method)解upper bounds
Example: T(n) = T(n/4) + T(n/2) + n²
              = n² + T(n/4) + T(n/2)
              = n² + (n/4)² + (n/2)² + T(n/16)² + T(n/8)² + T(n/8)² + T(n/4)²
              = ...
              = n²(1 + 5/16 + (5/16)² + (5/16)³ + ...)
              = Θ(n²) // ignore consts

### Ω(big-omege) lover bounds
Ω(g(n)) = { f(n):   
there exist constants c > 0, n0 > 0  
such that 0 ≤ cg(n) ≤ f(n)  
for all n ≥ n0 }  
**Example: √n=Ω(lgn)**

### Θ(big-theta) tight bounds
Θ(g(n)) = O(g(n)) ∩ Ω(g(n))
<hr/>

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