import type { NextPage } from 'next'
import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import axios from "axios";
import { useEffect, useState } from "react";
import { Item } from '../domain/domain'
import { Story } from '../components/story'

async function getPosts() {
  const url = "http://localhost:4000/"
  const response = await axios.get<Item[]>(url)
  console.log(response)
  return response.data
}

const Home: NextPage = () => {
  const [posts, setPosts] = useState<[] | Item[]>([])
  useEffect(() => {
    (async () => {
      const posts = await getPosts();
      setPosts(posts)
    })();
  }, [])
  return (
    <div className={styles.container} data-theme="garden">
      <Head>
        <title>Esteban Marin</title>
        <meta name="description" content="Salesfloor" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <div className='prose lg:prose:xl'>
          <h1>
            Hacker Rank Top news
          </h1>
        </div>
        <div className='prose lg:prose:xl'>
          <ul>
            {posts.map((post: Item) => (
              Story(post)
              // <li>{post.title}</li>
            ))}
          </ul>
        </div>

        <button className="btn w-64 rounded-full">Button</button>

      </main>
    </div>
  )
}

export default Home
