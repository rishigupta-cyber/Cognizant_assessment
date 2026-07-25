import React from 'react';
import './App.css';
import officeImg from './office.jpg';

function App() {
  const element = "Office Space";

  const jsxattr = <img src={officeImg} width="25%" height="25%" alt="Office Space" />;

  // Single object example (as per hint)
  const ItemName = { Name: "DBS", Rent: 50000, Address: 'Chennai' };

  // List of objects to loop through
  const officeList = [
    { Name: "DBS", Rent: 50000, Address: 'Chennai' },
    { Name: "TCS", Rent: 65000, Address: 'Bangalore' },
    { Name: "Infosys", Rent: 45000, Address: 'Hyderabad' },
    { Name: "Wipro", Rent: 72000, Address: 'Pune' },
  ];

  // Function to decide color based on rent
  const getColor = (rent) => {
    let colors = [];
    if (rent <= 60000) {
      colors.push('textRed');
    } else {
      colors.push('textGreen');
    }
    return colors.join(' ');
  };

  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {jsxattr}

      <h1>Name: {ItemName.Name}</h1>
      <h3 className={getColor(ItemName.Rent)}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>

      <hr />

      <h2>All Available Office Spaces</h2>
      {officeList.map((item, index) => (
        <div key={index} style={{ marginBottom: "20px" }}>
          <h1>Name: {item.Name}</h1>
          <h3 className={getColor(item.Rent)}>Rent: Rs. {item.Rent}</h3>
          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;