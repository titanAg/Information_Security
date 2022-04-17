// COSC 232 - Kyle Orcutt - Lab 8
// Randomizes various browser Navigator properties to throw finger printers off

const platforms = ["MacIntel","SunOS","Win16","Win32", "Android", "Linux x86_64", ""];
Object.defineProperty(navigator, 'platform',
    {
        get: function() {
            return platforms[Math.floor(Math.random() * platforms.length)];
        }
    }
);

const ram = [2, 4, 8, 16, 32];
Object.defineProperty(navigator, 'deviceMemory',
    {
        get: function() {
            return ram[Math.floor(Math.random() * ram.length)];
        }
    }
);

const cores = [2, 3, 4, 6, 8, 10];
Object.defineProperty(navigator, 'hardwareConcurrency',
    {
        get: function() {
            return cores[Math.floor(Math.random() * cores.length)];
        }
    }
);

const userAgents = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246", // edge win 10
    "Mozilla/5.0 (X11; CrOS x86_64 8172.45.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.64 Safari/537.36", // chromebook
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9", // mac OS
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0", // Firefox
    "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1", 
    "Mozilla/5.0 (Linux; Android 7.0; SM-G892A Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/60.0.3112.107 Mobile Safari/537.36"
];
Object.defineProperty(navigator, 'userAgent',
    {
        get: function() {
            return userAgents[Math.floor(Math.random() * userAgents.length)];
        }
    }
);

// https://docs.w3cub.com/dom/navigator/languages 
const languages = ["zh-CN", "en-GB,en", "en-US,en", "en-CA,en-US,en", "en-CA,en-US,en-GB,en"]
Object.defineProperty(navigator, 'languages',
    {
        get: function() {
            return languages[Math.floor(Math.random() * languages.length)];
        }
    }
);

// https://docs.w3cub.com/dom/navigator/oscpu
const oscpus = [
    "Windows NT x.y; Win64; x64",
    "Intel Mac OS X or macOS version x.y",
    "Windows NT x.y; WOW64",
    "uname -sm",
    ""
];
Object.defineProperty(navigator, 'oscpu',
    {
        get: function() {
            return oscpus[Math.floor(Math.random() * oscpus.length)];
        }
    }
);

// Already had this before realizing there were only 3 possible values
// https://docs.w3cub.com/dom/navigator/vendor
const vendors = [
    "Google Inc.",
    "Apple Computer, Inc.",
    ""
];
Object.defineProperty(navigator, 'vendor',
    {
        get: function() {
            return vendors[Math.floor(Math.random() * vendors.length)];
        }
    }
);