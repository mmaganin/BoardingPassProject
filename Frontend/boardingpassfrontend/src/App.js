import React from "react";
import { BrowserRouter as Router, Route } from 'react-router-dom';
import {Container } from "react-bootstrap";
import Welcome from './Views/Welcome';
import SearchResults from './Views/SearchResults';
import CustomerInfo from './Views/CustomerInfo';
import PurchasedTickets from './Views/PurchasedTickets';
import Ticket from "./Views/Ticket";

const App = () => {
    return (
        <Router>
            <Container>
                <Route path="/" component={Welcome} exact />
                <Route path="/searchresults" component={SearchResults} />
                <Route path="/customerinfo" component={CustomerInfo} />
                <Route path="/ticketconfirm" component={Ticket} />
                <Route path="/purchaselist" component={PurchasedTickets} />
            </Container>
        </Router>
    )
}