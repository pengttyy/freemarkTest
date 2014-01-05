自定义指令
<#macro greet>
    这是一个宏命令
</#macro>
下面我来调用宏命令
<@greet></@greet>
<@greet></@greet>
调用了两次

--------------------------------------------------------------------------
有参数的宏
<#macro greet param1 param2>
   <h1>参数1${param1}
    参数2${param1}
    ${testMacro}</h2>
</#macro>

<@greet "param1" "param2"/>

嵌套内容
<#macro greetContent name="pengttyy">
   姓名:${name}<p><#nested></p>p之间的内容是嵌套内容
   <@greet "pengttyy1" "pengttyy2"/>
</#macro>

测试：
<@greetContent "pengttyy">这个内容是嵌套内容哈哈</@greetContent>

<@greetContent "pengttyy"><@greet "pengttyy" "pengkai2"/></@greetContent>

---------------------------------------------------------------------------
循环变量
1.
<#macro forEach param>
   <#nested param>
</#macro>

<@forEach 2;x>
   ${x}这只是测试
</@forEach>

<#macro forEach param>
   <#list param as beging>
       <#nested beging>
   </#list>
</#macro>

<@forEach ["first","two","three","four"];element>
 <li>${element}.test</li>
</@forEach>

---------------------------------------------------------------------------
在模板中定义变量
  简单变量：它能从模板中的任何位置来访问，或者从使用 include 指令引入的
模板访问。可以使用 assign 或 macro 指令来创建或替换这些变量。
  局部变量： 它们只能被设置在宏定义体内，而且只在宏内可见。一个局部变量的生
存周期只是宏的调用过程。可以使用 local 指令在宏定义体内创建或替换局部变
量。
  循环变量：循环变量是由指令（如 list）自动创建的，而且它们只在指令的开始
和结束标记内有效。宏的参数是局部变量而不是循环变量。

<#assign x=1><#--创建变量-->
${x}
<#assign x=x+2>
${x}

当模型和模板同时存在相同变量时，模型变量会被隐藏，要想访问模型变量可以用如下方法使用
<#assign user="eclipse">
${user}
${.globals.user}







