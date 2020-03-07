start cmd /c "cd D:\DHBW\TinyWeb\tinyweb-scala\src\main\scala & scalac -d ..\..\..\target\classes\ com\mblinn\mbfpp\oo\tinyweb\*.scala & pause"

start cmd /c "cd D:\DHBW\TinyWeb\tinyweb-scala\src\main\scala & scalac -cp ..\..\..\target\classes\ -d ..\..\..\target\classes\ com\mblinn\mbfpp\oo\tinyweb\example\Example.scala & pause"

start cmd /c "cd D:\DHBW\TinyWeb\tinyweb-scala\src\main\scala & scalac -cp .;..\..\..\target\classes\ -d ..\..\..\target\classes\ tinyweb\*.scala & pause"
