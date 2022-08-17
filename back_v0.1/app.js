const express = require('express')
const axios = require('axios').default;
const cors = require('cors');
const app = express()
const port = 4000
const BASE_API_URL = 'https://hacker-news.firebaseio.com/v0';

const getStory = async (id) => {
  try {
    const story = await axios.get(`${BASE_API_URL}/item/${id}.json`);
    return story;
  } catch (error) {
    console.log('Error while getting a story.');
  }
};

const getStories = async () => {
  try {
    const { data: storyIds } = await axios.get(
      `${BASE_API_URL}/topstories.json`
    );
    const stories = await Promise.all(storyIds.slice(0, 30).map(getStory));
    return stories;
  } catch (error) {
    console.log('Error while getting list of stories.');
  }
};


app.get('/', (req, res) => {
  getStories().then(response => {
    const JSONResponse = response.map(x => JSON.stringify(x.data))
    const ObjectResponse = response.map(x => x.data)
    console.log(JSONResponse)
    res.send(ObjectResponse)
  })
})

app.get('/healthz', function (req, res) {
  // do app logic here to determine if app is truly healthy
  // you should return 200 if healthy, and anything else will fail
  // if you want, you should be able to restrict this to localhost (include ipv4 and ipv6)
  res.send('I am happy and healthy\n');
});

app.listen(port, () => {
  console.log(`[SERVER LISTENING] => ${port}`)
})