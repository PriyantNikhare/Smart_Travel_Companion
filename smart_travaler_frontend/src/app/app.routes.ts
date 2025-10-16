import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Register } from './registration/registration';
import { FlightUi } from './flight-ui/flight-ui';
import { TrainUi } from './train-ui/train-ui';
import { BusUi } from './bus-ui/bus-ui';
import { CabUi } from './cab-ui/cab-ui';
import { HotelUi } from './hotel-ui/hotel-ui';
import { ExpenseManager } from './expense-manager/expense-manager';
import { Homepage } from './homepage/homepage';

export const routes: Routes = [
    { path: '', redirectTo: 'register', pathMatch: 'full' },
    
    { path: 'login', component: Login },
    { path: 'register', component: Register },
    { path: 'homepage', component: Homepage },
    { path: 'expensemanager', component: ExpenseManager },
    { path: 'flights', component: FlightUi },
    { path: 'trains', component: TrainUi },
    { path: 'buses', component: BusUi },
    { path: 'cabs', component: CabUi },
    { path: 'hotels', component: HotelUi }
];