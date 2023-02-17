import openai
import os
import requests
import sys

img=sys.argv[1]

# for i, arg in enumerate(sys.argv[1:]):
    
openai.api_key_path = '/Apikey.txt'

resp=openai.Image.create(prompt=img,n=1,size="256x256")

image_url = resp['data'][0]['url']



img_data = requests.get(image_url).content
with open('Out.jpeg', 'wb') as handler:
    handler.write(img_data)

os.popen('sudo rm -rf /var/www/html/Out.jpeg')
os.popen('sudo mv Out.jpeg /var/www/html/')

