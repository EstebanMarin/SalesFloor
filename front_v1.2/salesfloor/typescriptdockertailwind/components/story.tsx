import React from "react";
import { Item } from "../domain/domain"

export const Story = ({ id, by, title, kids, time, url }: Item) => {
    return (
        <div className="m-6 card w-300 bg-base-100 shadow-xl" data-theme="retro" key={id}>
            <div className="card-body">
                <a href={url} target="_blank" rel="noreferrer">
                    <h2 className="card-title">{title}</h2>
                </a>
                <div className="flex flex-row flex-grow">
                    <p>By: {by}</p>
                    <div className="stat">
                        <div className="stat-title">Comments:</div>
                        <div className="flex flex-row">
                            <div className="stat-value text-primary">{kids && kids.length > 0 ? kids.length : 0}</div>
                            <div className="stat-figure text-primary">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="w-8 h-8 stroke-current"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z"></path></svg>
                            </div>
                        </div>
                    </div>
                </div>
                <span>
                    {new Date(time * 1000).toLocaleDateString('en-US', {
                        hour: 'numeric',
                        minute: 'numeric'
                    })}
                </span>
            </div>
        </div>
    )
}


