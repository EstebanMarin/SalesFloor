import type { NextPage } from 'next'
import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'

const Home: NextPage = () => {
  return (
    <div className={styles.container}>
      <Head>
        <title>Esteban Marin</title>
        <meta name="description" content="Salesfloor" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <h1 className="text-3xl font-bold underline">
          Nice one
        </h1>
        <button className="btn w-64 rounded-full">Button</button>

      </main>
    </div>
  )
}

export default Home
