import openai
import sys
openai.api_key_path = '/Apikey.txt'

prompt = " ".join(sys.argv[1:])
model = "text-davinci-002"
temperature = 0.7
max_tokens = 800

response = openai.Completion.create(
    engine=model,
    prompt=prompt,
    temperature=temperature,
    max_tokens=max_tokens,
)

paragraph = response.choices[0].text.strip()
print(paragraph)