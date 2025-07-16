import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import AnimatedLogo from "../components/AnimatedLogo.jsx";
import Welcome from "../pages/Welcome.jsx";
import Backdrop from "../components/Backdrop.jsx";
import Modal from "../components/Modal.jsx";
import App from "../App.jsx";

const ComponentPreviews = () => {
    return (
        <Previews palette={<PaletteTree/>}>
            <ComponentPreview path="/AnimatedLogo">
                <AnimatedLogo/>
            </ComponentPreview>
            <ComponentPreview path="/ComponentPreviews">
                <ComponentPreviews/>
            </ComponentPreview>
            <ComponentPreview path="/Welcome">
                <Welcome/>
            </ComponentPreview>
            <ComponentPreview path="/Backdrop">
                <Backdrop/>
            </ComponentPreview>
            <ComponentPreview path="/Modal">
                <Modal/>
            </ComponentPreview>
            <ComponentPreview path="/App">
                <App/>
            </ComponentPreview>
        </Previews>
    )
}

export default ComponentPreviews