const http = require('http');

const server = http.createServer((req, res) => {
    // Log the incoming request method, URL, and headers
    console.log(`${req.method} ${req.url}`);
    console.log('Headers:');
    console.log(req.headers);

    // Send a dummy response
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Dummy response from dummy REST service\n');
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});

