import React from "react";
import { View,Text, StyleSheet, TouchableOpacity, TextInput } from 'react-native';
import * as Animatable from 'react-native-animatable'
import { useNavigation } from "@react-navigation/native";
export default function Cadastro (){
    const navigation = useNavigation();
    return(
        <View style={styles.container}>
            <Animatable.View animation={"fadeInLeft"}  delay={500} style={styles.containerHeader}>
            <Text style={styles.message}>Cadastro</Text>
            </Animatable.View>

            <Animatable.View animation={"fadeInUp"} style={styles.containerForm}>
                <Text style={styles.title}>Nome</Text>
                <TextInput
                    placeholder="Digite seu nome..."
                    style={styles.input}
                    />
                    <Text style={styles.title}>CPF</Text>
                <TextInput
                    placeholder="Digite seu CPF..."
                    style={styles.input}
                    />
                    <Text style={styles.title}>Email</Text>
                <TextInput
                    placeholder="Digite seu email..."
                    style={styles.input}
                    />
                     <Text style={styles.title}>Senha</Text>
                <TextInput
                    placeholder="Crie uma senha..."
                    style={styles.input}
                    secureTextEntry={true}
                    />
                    <TouchableOpacity style={styles.button}  onPress={()=> navigation.navigate('Login')}>
                        <Text style={styles.buttonText}>Cadastrar</Text>
                    </TouchableOpacity>
            </Animatable.View>
        </View>
    );
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        backgroundColor:'#38a29d'
    },
    containerHeader:{
        marginTop:'14%',
        marginBottom: '8%',
        paddingStart:'5%',
    },
    message:{
        fontSize:28,
        fontWeight:"bold",
        color: '#FFF'
    },
    containerForm:{
        backgroundColor:'#FFF',
        flex:1,
        borderTopLeftRadius:25,
        borderTopRightRadius:25,
        paddingStart:'5%',
        paddingEnd:'5%'
    },
    title:{
        fontSize:20,
        marginTop:20,
    },
    button:{
        backgroundColor:'#38a29d',
        width:'100%',
        borderRadius:4,
        paddingVertical:8,
        marginTop:14,
        justifyContent:'center',
        alignItems:'center'
    },
    buttonText:{
        color:'#FFF',
        fontSize:18,
        fontWeight:'bold'
    },
    buttonRegister:{
        marginTop:14,
        alignSelf:'center'
    },
    registerText:{
        color:'#a1a1a1'
    }



})