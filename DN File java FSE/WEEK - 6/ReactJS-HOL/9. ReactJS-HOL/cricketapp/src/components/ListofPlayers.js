import React from 'react';

function ListofPlayers() {
  const players = [
    { name: "Rohit Sharma", score: 85 },
    { name: "Virat Kohli", score: 92 },
    { name: "KL Rahul", score: 45 },
    { name: "Shubman Gill", score: 60 },
    { name: "Suryakumar Yadav", score: 78 },
    { name: "Hardik Pandya", score: 55 },
    { name: "Ravindra Jadeja", score: 40 },
    { name: "Jasprit Bumrah", score: 20 },
    { name: "Mohammed Shami", score: 15 },
    { name: "Axar Patel", score: 65 },
    { name: "Ishan Kishan", score: 72 }
  ];

  // Arrow function to filter players with scores below 70
  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;