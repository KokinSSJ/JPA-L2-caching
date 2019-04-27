echo "Build: hibernate-L2"
set start=%cd%
CALL gradlew  clean war || goto :error:

set JBOSS=C:\Users\Kokin\Desktop\jboss-eap-7.1\bin
call del /q %JBOSS%\..\standalone\deployments\
call xcopy %cd%\build\libs\* %JBOSS%\..\standalone\deployments

cd %JBOSS%
start cmd /k standalone.bat
cd %start%
echo %time%