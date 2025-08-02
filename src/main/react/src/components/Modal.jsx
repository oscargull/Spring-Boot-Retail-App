import { motion } from 'framer-motion';
import Backdrop from './Backdrop.jsx'

const Modal = ({ handleClose, children, isOpen}) => {
    return (
      <Backdrop
      onClick={handleClose}
      >
          <motion.div
              className="modal"
              onClick={(e) => e.stopPropagation()}
              variants={dropIn}
              initial="hidden"
              animate="visible"
              exit="exit"
          >
              {children}
              <button onClick={handleClose}>Close</button>
          </motion.div>

      </Backdrop>
    );

}

const dropIn = {
    hidden: {
        y: "-100vh"
    },
    visible: {
        y: "0vh",
        opacity: 1,
        transition: {
            duration: 0.2,
            type: "spring"
        }
    },
    exit: {
        y: "100vh"
    }
}

export default Modal;