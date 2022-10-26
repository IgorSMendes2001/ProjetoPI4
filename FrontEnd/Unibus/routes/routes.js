import { createNativeStackNavigator } from "@react-navigation/native-stack";

import Login from '../components/Login'
import Welcome from '../components/Welcome'
import Rotas from './../components/Rotas';

const Stack = createNativeStackNavigator();

export default function Routes(){
    return(
        <Stack.Navigator>
            <Stack.Screen
            name="Bem-Vindo"
            component={Welcome}
            options={{headerShown:false}}
            />
            <Stack.Screen
            name="Login"
            component={Login}
            options={{headerShown:false}}
            />
            <Stack.Screen
            name="Rotas"
            component={Rotas}
            options={{headerShown:false}}
            />
        </Stack.Navigator>
    )

}