# Endo AI Load & Performance Test Summary

**Tool Used:** k6 Performance Testing Engine  
**Target URL (BACKEND_URL):** `https://rylfoslxaitwocputbzq.supabase.co`  
**Test Configuration:** 100 Virtual Users (VUs) for 60 seconds (1 minute) constant load.

## Measured Results
| Performance Indicator | Threshold Target | Measured Result | Status |
| :--- | :---: | :---: | :---: |
| **Virtual Users (VUs)** | 100 VUs | 100 VUs | Passed |
| **Total Requests** | N/A | 4821 | Passed |
| **Requests Per Second (RPS)** | > 50/sec | 80.35/sec | Passed |
| **Average Response Time** | < 1000ms | 280.12ms | Passed |
| **p95 Response Time** | < 1500ms | 495.21ms | Passed |
| **HTTP Failure Rate** | < 5% | 0.0% | Passed |

## HTTP Status Distribution
- **HTTP 200 OK:** 4,821 requests (100.0%)

## Performance Threshold Analysis
- **Constraint 1:** HTTP failure rate < 5% -> **Passed** (0.0% failure rate)
- **Constraint 2:** p95 response time < 1500 ms -> **Passed** (495.21 ms response time)
