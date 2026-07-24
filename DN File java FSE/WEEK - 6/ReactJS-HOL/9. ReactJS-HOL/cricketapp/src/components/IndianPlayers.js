import React from 'react';

function IndianPlayers() {
  const allPlayers = [
    "Rohit Sharma", "Virat Kohli", "KL Rahul", "Shubman Gill",
    "Suryakumar Yadav", "Hardik Pandya", "Ravindra Jadeja",
    "Jasprit Bumrah", "Mohammed Shami", "Axar Patel", "Ishan Kishan"
  ];

  // Destructuring to pick odd-indexed and even-indexed players
  const [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11] = allPlayers;
  const oddTeamPlayers = [p1, p3, p5, p7, p9, p11];
  const evenTeamPlayers = [p2, p4, p6, p8, p10];

  const T20players = ["Rohit Sharma", "Virat Kohli", "Hardik Pandya"];
  const RanjiTrophyPlayers = ["Prithvi Shaw", "Sarfaraz Khan", "Yashasvi Jaiswal"];

  // Merge feature of ES6 using spread operator
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>{oddTeamPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h2>Even Team Players</h2>
      <ul>{evenTeamPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h2>Merged Players (T20 + Ranji Trophy)</h2>
      <ul>{mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
}

export default IndianPlayers;