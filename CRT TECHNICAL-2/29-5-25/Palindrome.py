def palindrome(s):
    string=''.join(c.lower() for c in s if c.isalnum())
    return s==string[::-1]
s="hello: @world"
print(palindrome(s))