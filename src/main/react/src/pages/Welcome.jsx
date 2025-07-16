import { useState } from 'react';
import {motion, scale, AnimatePresence} from 'framer-motion';
import '../styles/Welcome.css'
import AnimatedLogo from '../components/AnimatedLogo.jsx';
import Modal from "../components/Modal.jsx";

function Welcome(){
    const [isModalOpen, setModalOpen] = useState(false);

    return (
        <div className={"welcome-page"}>

            <h1>Bienvenido a la app</h1>

        <AnimatedLogo/>
            <motion.button
                id={"btn-login"}
                whileHover={{ scale: 1.3 }}
                whileTap={{ scale: 0.9}}
                onClick={() => (isModalOpen ? setModalOpen(false) : setModalOpen(true))}
            >
                    Login
            </motion.button>

            <AnimatePresence>
                {isModalOpen && <Modal isModalOpen={isModalOpen} handleClose={()=>setModalOpen(false)} text={"test"}/>}
            </AnimatePresence>

        </div>
    )
}

export default Welcome;