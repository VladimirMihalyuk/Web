cd C:\glassfish4\glassfish\bin

set Arr[0]=http://desktop-03g58vn:8080/Server_lab12_war_exploded/HorseDAOService?wsdl
set Arr[1]=http://desktop-03g58vn:8080/Server_lab12_war_exploded/ClientDAOService?wsdl
set Arr[2]=http://desktop-03g58vn:8080/Server_lab12_war_exploded/BetDAOService?wsdl
set Arr[3]=http://desktop-03g58vn:8080/Server_lab12_war_exploded/RaceDAOService?wsdl

set "x=0"

:SymLoop
if defined Arr[%x%] (
    call wsimport -keep -Xnocompile -d "C:\Users\isysoi\GitHub\Web\lab12\Client\src"  %%Arr[%x%]%%
    set /a "x+=1"
    GOTO :SymLoop
)
pause