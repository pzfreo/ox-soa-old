var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200);
  res.end("hello world\n");
}).listen(8001);
http.createServer(function (req, res) {
  res.writeHead(200);
  res.end("hello sandbox\n");
}).listen(8002);
