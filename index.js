var shelljs = require('shelljs');

module.exports = function(name,build_dir, src_file, test_build_dir, test_file, callback) {
  var junit_path = __dirname + '/lib/junit4-4.11.jar';
  var hamcrest_path =  __dirname + '/lib/hamcrest-core-1.3.jar';
  var json_runner =  __dirname + '/dist/jsonrunner.jar';
  var json_simple = __dirname + '/lib/json-simple-1.1.1.jar';
  shelljs.exec('javac -d ' + build_dir + ' ' + src_file, function(code, output) {

      if (!code) {
         var class_path  =  junit_path +':' + build_dir +':' + json_runner;
         shelljs.exec('javac -d ' + test_build_dir + ' -cp ' + class_path + ' ' + test_file, function(code, output) {
           if (!code) {
		class_path = hamcrest_path + ':' + junit_path + ':' + test_build_dir +':' + json_runner +':' + json_simple  + ":" + build_dir;
            shelljs.exec('java -cp ' + class_path + ' org.junit.runner.JsonRunner ' + name, {silent: true}, function(code, arr) {
             arr = JSON.parse(arr);

	      for (var key in arr) {


		var obj = arr[key];
		var desc = obj.description;
		var stats = obj.status;
		if (stats == "failed") {
                  console.log(obj);
		  callback(obj);
		  return;
		}
	       }
              });
          }
        });
      }
  });
}
