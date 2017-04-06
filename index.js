var shelljs = require('shelljs');


shelljs.exec('javac -d ./palindromeString/build/classes/ ./palindromeString/src/palindromeString.java', {
  silent: true
}, function(code, output) {
  if (!code) {
    shelljs.exec('javac -d ./palindromeString/build/test/classes/ -cp ./lib/junit4-4.11.jar:./palindromeString/build/classes ./palindromeString/test/palindromeStringTest.java', {
      silent: true
    }, function(code, output) {
      if (!code) {
        shelljs.exec('java -cp ./lib/hamcrest-core-1.3.jar:./lib/junit4-4.11.jar:./palindromeString/build/classes/:./palindromeString/build/test/classes/:./dist/jsonrunner.jar:./lib/json-simple-1.1.1.jar org.junit.runner.JsonRunner palindromeStringTest', {
          silent: true
        }, function(code, output) {
          console.log(output);
        })
      }
    })
  }
});
