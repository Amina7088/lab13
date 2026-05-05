# /security

Perform OWASP Top 10 security check on the given code.

Check:
1. Injection (SQL, NoSQL)
2. Broken Authentication
3. Sensitive Data Exposure (hardcoded credentials, logs)
4. Security Misconfiguration
5. Missing input validation (@Valid usage)

Output: list of risks with severity and fix suggestion.