import * as React from 'react';
import {Stack} from "@mui/material";
import {Button} from "@mui/material";

const InsertButton: React.FC = () => {
    return (
        <Stack direction="column" style={{position: 'fixed', bottom: '85px', left: '300px'}}>
            <Button variant="contained">Insert</Button>
        </Stack>
    );
}
export default InsertButton;