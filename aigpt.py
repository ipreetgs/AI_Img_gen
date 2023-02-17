import openai
import os
import sys

img=sys.argv[1]
openai.api_key_path = 'apikey'
# response = openai.Image.create(
  # prompt="a white siamese cat",
  # n=1,
  # size="1024x1024"
# )
# image_url = response['data'][0]['url']

# a=openai.Model.list()
# print(a)

resp=openai.Image.create(prompt=img,n=1,size="256x256")

image_url = response['data'][0]['url']

os.popen(f'wget {image_url}>1.png')

os.popen('sudo rm -rf /var/www/html/1.png')
os.popen('sudo mv 1.png /var/www/html/')

