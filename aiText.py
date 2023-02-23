import openai
import os
import requests
import sys

InpTxt=" ".join(sys.argv[1:])

openai.api_key_path = '/Apikey.txt'

# list engines
engines = openai.Engine.list()
# print the first engine's id
# print(engines)
# print(engines.data[0].id)

tc=openai.Completion.create(prompt=InpTxt,engine="text-curie-001")
completion = openai.Completion.create(engine="ada", prompt=InpTxt)
# passage=openai.Embedding.create(input=InpTxt, engine="text-curie-001")
# print(passage)
print(completion.choices[0].text)
print(tc.choices[0].text)