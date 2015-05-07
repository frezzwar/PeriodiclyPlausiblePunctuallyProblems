:: ** DELETE OLD SABLECC GENERATED FILES **
rmdir /s /q "compiler/src/main/java/compiler/analysis"
rmdir /s /q "compiler/src/main/java/compiler/lexer"
rmdir /s /q "compiler/src/main/java/compiler/node"
rmdir /s /q "compiler/src/main/java/compiler/parser"

:: ** GENERATE NEW SABLECC FILES **
java -jar sablecc-3.7/lib/sablecc.jar compiler/src/main/java/compiler.sable