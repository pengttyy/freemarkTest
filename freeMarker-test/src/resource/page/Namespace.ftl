<#--[#ftl]-->
<#import "lib.ftl" as mySpace>
下面是从外部引入的宏
<@mySpace.copyright "20140105"/>

在引用的命名空间上编写变量
<#assign mail="pengttyy@163.com" in mySpace>
<@mySpace.copyright "20140106"/>
以上变量被覆盖

-----------------------------------------------------------
命名空间和数据模型
数据模型的变量在任何位置都是可见的

空白处理
忽略某些模板文件的空白的工具（解析阶段空白就被移除了）：
  剥离空白： 这个特性会自动忽略在 FTL 标签周围多余的空白。这个特性可以通
                   过模板来随时使用和禁用。
  微调指令：t，rt 和 lt，使用这些指令可以明确地告诉 FreeMarker 去忽略
                    某些空白。可以阅读参考手册来获取更多信息。
  FTL 参数 strip_text：这将从模板中删除所有顶级文本。对模板来说这很
                   有用，它只包含某些定义的宏（还有以他一些没有输出的指令），因为它可以
                    移除宏定义和其他顶级指令中的换行符，这样可以提高模板的可读性。
从输出中移除空白的工具（移除临近的空白）：
    compress指令
    
    
