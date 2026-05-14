FROM  gedalavijay2001/apitestimage:latest
WORKDIR /app
COPY . .
CMD ["mvn", "clean", "test"]