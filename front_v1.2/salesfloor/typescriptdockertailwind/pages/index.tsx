import type { NextPage } from 'next'
import Head from 'next/head'
import styles from '../styles/Home.module.css'
import axios from "axios";
import { useState } from "react";
import { Item } from '../domain/domain'
import { Story } from '../components/story'

async function getPosts() {
  const back = process.env.NEXT_PUBLIC_BACKEND ? process.env.NEXT_PUBLIC_BACKEND : "http://localhost:4000/"
  const response = await axios.get<Item[]>(back)
  return response.data
}

const Home: NextPage = () => {
  const [posts, setPosts] = useState<[] | Item[]>([])
  const [isLoading, setIsLoading] = useState(false);

  const handleClick = async () => {
    setIsLoading(true)
    try {
      const posts = await getPosts()
      setPosts(posts)
    } catch {
      console.log(`[Error fetching]`)
    } finally {
      setIsLoading(false)
    }
  }

  const loading = () => {
    return (
      <>
        <div className="flex justify-center items-center">
          <div className="spinner-border animate-spin inline-block w-8 h-8 border-4 rounded-full black" role="status">
            <span className="visually-hidden">Loading</span>
          </div>
        </div>
      </>
    )
  }

  const postsUI = (posts: Item[]) => {
    return (
      <>
        {posts.map((post: Item) => (
          Story(post)
        ))}
      </>
    )
  }


  return (
    <div className={styles.container} data-theme="garden">
      <Head>
        <title>Esteban Marin</title>
        <meta name="description" content="Salesfloor" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <div className='prose lg:prose:xl flex flex-col'>
          <div>
            <h1>
              Hacker Rank Top news
            </h1>
          </div>
          <div className="text-center">
            <p> For <b>Node.js</b> <a className="link link-primary" href="http://localhost:3000">localhost:3000</a></p>
            <p> For <b>Scala</b> <a className="link link-primary" href="http://localhost:3002">localhost:3002</a></p>
            <p>Benchmark <b>Node.js</b> vs <b>Scala</b> local service</p>
          </div>
        </div>
        <button className="btn btn-primary" onClick={handleClick}>Trigger the test</button>
        {isLoading ? loading() : postsUI(posts)}
        <div className='prose lg:prose:xl'>
        </div>
      </main>
    </div>
  )
}

export default Home
