import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import axios from "axios";
import { useEffect, useState } from "react";

type Item = {
  by: string;
  decendants: number;
  id: number;
  kids: number[];
  score: number;
  time: number;
  title: string;
  type: string;
  url: string
}

async function getPosts() {
  const url = "http://localhost:4000/"
  const response = await axios.get<Item[]>(url)
  console.log(response)
  return response.data
}


export default function Home() {
  const [posts, setPosts] = useState<[] | Item[]>([])
  useEffect(() => {
    (async () => {
      const posts = await getPosts();
      setPosts(posts)
    })();
  }, [])
  return (
    <div className={styles.container}>
      <Head>
        <title>Esteban Marin</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <h1 className={styles.title}>
          HackerNews App
        </h1>
        <h1 className="text-3xl font-bold underline">
          Hello world!
        </h1>


        <ul>
          {posts.map((post: Item) => (
            <li>{post.title}</li>
          ))}
        </ul>

      </main>
    </div>
  )
}
