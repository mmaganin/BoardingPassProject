import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import SearchResults from "./Views/SearchResults";
import CustomerInfo from "./Views/CustomerInfo";
import PurchasedTickets from "./Views/PurchasedTickets";
import Ticket from "./Views/Ticket";
import Welcome from "./Views/Welcome";
import Header from "./Components/Header";

function App() {
 return (
  <Router>
    <Header />
    <Routes>
     <Route path="/" element={<Welcome />} exact />
     <Route path="/searchresults" element={<SearchResults />} />
     <Route path="/customerinfo" element={<CustomerInfo />} />
     <Route path="/ticketconfirm" element={<Ticket />} />
     <Route path="/purchaselist" element={<PurchasedTickets />} />
    </Routes>
  </Router>
 );
};

export default App;
