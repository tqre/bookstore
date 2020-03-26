#!/usr/bin/env python3

import bcrypt
from getpass import getpass

print("Quick Bcrypt hasher")
passwd = getpass().encode()
print("Hashed password:")
print(bcrypt.hashpw(passwd, bcrypt.gensalt()))
