FROM node:alpine
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install 
COPY . .
RUN npm install
CMD [ "npm","run", "start" ]