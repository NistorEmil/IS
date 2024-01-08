import React from 'react';
import InstagramLogo from './Instagram_logo.svg'
import YoutubeLogo from './Youtube_logo.svg'
import FacebookLogo from './Facebook_logo.svg'
import XLogo from './X_logo.svg'

const Footer: React.FC = () => {
    return (
        <footer style={{ backgroundColor: '#2196f3', padding: '10px', display: 'flex', justifyContent: 'flex-end',maxWidth: '100%'  }}>
            <div>
                <img src={InstagramLogo} alt=" " style={{ width: '30px', marginRight: '2px' }} />

            </div>
            <div>
                <img src={YoutubeLogo} alt=" " style={{ width: '30px', marginRight: '2px' }} />

            </div>
            <div>
                <img src={FacebookLogo} alt=" " style={{ width: '30px', marginRight: '2px' }} />

            </div>

            <div>
                <img src={XLogo} alt=" " style={{ width: '30px', marginRight: '2px' }} />

            </div>

        </footer>
    );
};

export default Footer;