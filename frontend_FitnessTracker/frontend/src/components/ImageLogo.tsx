import React from 'react';
import img1 from '../Router/fitnesstracker-high-resolution-logo-white.jpg';

const ImageComponent: React.FC = () => {
    return (
        <div style={{ float: 'left', marginRight: '20px', marginBottom: '20px' }}>
            <img src={img1} alt="" style={{ width: '100%', height: 'auto', borderRadius: '4px', padding: '5px' }} />
        </div>
    );
};

export default ImageComponent;