import { StatusBar } from 'react-native';
import Routes from './routes/routes';
import { NavigationContainer } from '@react-navigation/native'

export default function App() {
  return (
<NavigationContainer>
    <StatusBar backgroundColor={"38A69D"} barStyle = "light-content" />
    <Routes/>
    </NavigationContainer>
  );
}


;
