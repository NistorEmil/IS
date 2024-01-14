// Header.tsx
import React from 'react';
import HeaderButtons from "./headerButtons";
import {AppBar, Toolbar, Typography} from '@mui/material';



const Header: React.FC = () => {
    return (
        <AppBar position="static">
            <Toolbar>
                <div style={{marginLeft:"0.5cm",  marginRight: "auto" }}>
                <Typography variant="h2"  style={{ display: "flex", justifyContent: 'space-between', textAlign: "center"}}>Fitness Tracker</Typography>
                {/* Other header content */}
                </div>
                <div style={{ marginLeft:"auto"}} >
                <HeaderButtons />
                </div>
            </Toolbar>
        </AppBar>
    );
};

export default Header;
